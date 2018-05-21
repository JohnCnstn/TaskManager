import * as React from 'react';
import './list.css';

interface Tour {
    id: number;
    name: string;
    date: string;
}

interface TourListProps {

}

class TourList extends React.Component<{}, any> {
    constructor(props: TourListProps) {
        super(props);

        this.state = {
            tours: [],
            isLoading: false
        };
    }
    componentDidMount() {
        this.setState({isLoading: true});

        fetch('http://localhost:8080/tours')
            .then(response => response.json())
            .then(data => this.setState({tours: data, isLoading: false}))
            .catch(alert);
    }
    render() {
        const {tours, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div>
                <h2>Tours</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    {tours.map((tour: Tour) =>
                        <tr key={tour.id}>
                            <td>{tour.name}</td>
                            <td>{tour.date}</td>
                        </tr>
                    )}
                </table>
            </div>
        );
    }
}

export default TourList;