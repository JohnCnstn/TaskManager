import * as React from 'react';
import './list.css';

interface Task {
    id: number;
    name: string;
    path: string;
}

interface TaskListProps {

}

class TaskList extends React.Component<{}, any> {
    constructor(props: TaskListProps) {
        super(props);

        this.state = {
            tasks: [],
            isLoading: false
        };
    }
    componentDidMount() {
        this.setState({isLoading: true});

        fetch('http://localhost:8080/tasks')
            .then(response => response.json())
            .then(data => this.setState({tasks: data, isLoading: false}));
    }
    render() {
        const {tasks, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div>
                <h2>Tasks</h2>
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Path</th>
                    </tr>
                    {tasks.map((task: Task) =>
                        <tr key={task.id}>
                            <td>{task.name}</td>
                            <td>{task.path}</td>
                        </tr>
                    )}
                </table>
            </div>
        );
    }
}

export default TaskList;