import * as React from 'react';
import './list.css';

interface Manager {
    id: number;
    firstName: string;
    lastName: string;
}

interface ManagerListProps {

}

class ManagerList extends React.Component<{}, any> {
    constructor(props: ManagerListProps) {
        super(props);

        this.state = {
            managers: [],
            isLoading: false
        };
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('http://localhost:8080/managers')
            .then(response => response.json())
            .then(data => this.setState({managers: data, isLoading: false}));
    }
    render() {
        const {managers, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div>
                <h2>Managers</h2>
                <table>
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                    </tr>
                    {managers.map((manager: Manager) =>
                        <tr key={manager.id}>
                            <td>{manager.firstName}</td>
                            <td>{manager.lastName}</td>
                        </tr>
                    )}
                </table>
            </div>
        );
    }
}

export default ManagerList;