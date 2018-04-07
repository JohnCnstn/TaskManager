import * as React from 'react';
import './list.css';

interface Worker {
    id: number;
    firstName: string;
    lastName: string;
}

interface WorkerListProps {

}

class WorkerList extends React.Component<{}, any> {
    constructor(props: WorkerListProps) {
        super(props);

        this.state = {
            workers: [],
            isLoading: false
        };
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('http://localhost:8080/workers')
            .then(response => response.json())
            .then(data => this.setState({workers: data, isLoading: false}));
    }
    render() {
        const {workers, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div>
                <h2>Workers</h2>
                <table>
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                    </tr>
                    {workers.map((worker: Worker) =>
                        <tr key={worker.id}>
                            <td>{worker.firstName}</td>
                            <td>{worker.lastName}</td>
                        </tr>
                    )}
                </table>
            </div>
        );
    }
}

export default WorkerList;