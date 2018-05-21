import * as React from 'react';

class NewTour {
    id: number;
    name: string;
    date: string;
}

interface TourDto {
    id: number;
    countryId: number;
    name: string;
    date: string;
}

interface TourProps {
    countryId: number;
}

class Tour extends React.Component<TourProps, any> {
    constructor(props: TourProps) {
        super(props);

        this.state = {
            tours: [],
            idForEdit: -1,
            txtForEdit: 'name',
            date: 'date',
            edit: false,
            isLoading: false
        };
    }

    componentDidMount() {

        this.setState({isLoading: true});

        fetch('http://localhost:8080/tours/' + this.props.countryId)
            .then(response => response.json())
            .then(data => this.setState({tours: data, isLoading: false}));
    }

    editTour(id: number) {

        let newName = this.state.txtForEdit;
        let newDate = this.state.date;

        let arr = this.state.tours;

        for (let i = 0; i < arr.length; i++) {
            if (arr[i].id === id) {
                let editedTour = arr[i];
                editedTour.name = newName;
                editedTour.date = newDate;

                fetch('http://localhost:8080/tours', {
                    method: 'put',
                    headers: {
                        'Accept': 'application/json, text/plain, */*',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({name: editedTour.name, date: editedTour.date, tourId: id})
                });

            }
        }

        this.setState({tours: arr, edit: false});

    }

    newTour(text: string, countryId: number) {
        let arr = this.state.tours;
        let newTour = new NewTour();
        if (arr.length === 0) {
            newTour.id = 0;
        } else {
            let lastTour = arr[arr.length - 1];
            newTour.id = lastTour.id + 1;
        }
        newTour.name = text;
        newTour.date = text;
        arr.push(newTour);
        this.setState({tours: arr});

        fetch('http://localhost:8080/tours', {
            method: 'post',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({name: newTour.name, date: newTour.date, countryId: countryId})
        });
    }

    removeTour(id: number) {

        fetch('http://localhost:8080/tours/' + id, { method: 'DELETE'})
            .then(
                data => {
                    let arr = this.state.tours;

                    for (let i = 0; i < arr.length; i++) {
                        if (arr[i].id === id) {
                            arr.splice(i, 1);
                        }
                    }
                    this.setState({tours: arr});
                }
            );
    }

    rendEdit(id: number) {
        return (
            <div className="box">
                <div className="tour-edit">
                    <label>Name</label>
                    <input onChange={(event) =>  this.setState({ txtForEdit: event.target.value })}/>
                    <label>Path</label>
                    <input onChange={(event) =>  this.setState({ date: event.target.value })}/>

                    <button onClick={this.editTour.bind(this, id)}>Edit</button>
                </div>
            </div>
        );
    }

    setEdit(id: number) {
        this.setState({edit: true, idForEdit: id});
    }

    rendNorm() {
        return (
            <div>
                <button className="add-button" onClick={this.newTour.bind(this, 'custom data', this.props.countryId)}>Add new Tour</button>
                {this.state.tours.map((tour: TourDto) =>
                    <div key={tour.id} className="tour">
                        <div style={{display: 'inline-flex'}}>
                            <div className="tour-info">
                                <p>Tour ID: {tour.id}</p>
                                <p>Name: {tour.name}</p>
                                <p>Path: {tour.date}</p>
                            </div>
                            <div className="tour-buttons">
                                <button onClick={this.setEdit.bind(this, tour.id, this.props.countryId)}>Edit</button>
                                <button onClick={this.removeTour.bind(this, tour.id)}>Remove</button>
                            </div>
                        </div>
                    </div>
                )}
            </div>
        );
    }

    render() {
        if (this.state.edit) {
            return this.rendEdit(this.state.idForEdit);
        } else {
            return this.rendNorm();
        }
    }
}

export default Tour;