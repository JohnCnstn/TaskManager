import * as React from 'react';
import './list.css';

interface Client {
    id: number;
    firstName: string;
    lastName: string;
}

interface ClientListProps {

}

class ClientList extends React.Component<{}, any> {
    constructor(props: ClientListProps) {
        super(props);

        this.state = {
            clients: [],
            isLoading: false
        };
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('http://localhost:8080/clients')
            .then(response => response.json())
            .then(data => this.setState({clients: data, isLoading: false}))
            .catch(alert);
    }
    render() {
        const {clients, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div>
                <h2>Clients</h2>
                <table>
                    <thead>
                        <tr>
                            <th>First name</th>
                            <th>Last name</th>
                        </tr>
                    </thead>
                    {clients.map((client: Client) =>
                        <tr key={client.id}>
                            <td>{client.firstName}</td>
                            <td>{client.lastName}</td>
                        </tr>
                    )}
                </table>
            </div>
        );
    }
}

export default ClientList;