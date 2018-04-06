import * as React from 'react';

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
                <h2>Task List</h2>

                {tasks.map((task: Task) =>
                    <div key={task.id}>
                        {task.name}:
                        {task.path}
                    </div>
                )}
            </div>
        );
    }
}

export default TaskList;