import * as React from 'react';
import Tour from './Tour';
import './list.css';

interface Country {
    id: number;
    name: string;
    description: string;
}

class CountryList extends React.Component<any, any> {
    constructor(props: any) {
        super({props});

        this.state = {
            countries: [],
            isLoading: false
        };
    }

    componentDidMount() {
        this.setState({isLoading: true});

        if ((this.props.role === 'MANAGER') || (this.props.role === 'ADMIN')) {

            fetch('http://localhost:8080/countries')
                .then(response => response.json())
                .then(data => this.setState({countries: data, isLoading: false}))
                .catch(alert);

        }

        if ((this.props.role === 'CLIENT')) {

            fetch('http://localhost:8080/country/' + this.props.userName)
                .then(response => response.json())
                .then(data => this.setState({countries: data, isLoading: false}))
                .catch(alert);

        }
    }

    render() {
        const {countries, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
                <div>
                    <h2>countries</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Tours</th>
                            </tr>
                        </thead>
                        {countries.map((country: Country) =>
                            <tr key={country.id}>
                                <td>{country.name}</td>
                                <td>{country.description}</td>
                                <td><Tour countryId={country.id}/></td>
                            </tr>
                        )}
                    </table>
                </div>
        );
    }
}

export default CountryList;