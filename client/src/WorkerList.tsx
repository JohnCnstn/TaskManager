import * as React from 'react';

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
                <h2>Worker List</h2>
                {workers.map((worker: Worker) =>
                    <div key={worker.id}>
                        {worker.firstName}:
                        {worker.lastName}
                    </div>
                )}
            </div>
        );
    }
}

export default WorkerList;