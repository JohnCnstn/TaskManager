import * as React from 'react';

interface TaskDto {
    id: number;
    projectId: number;
    name: string;
    path: string;
}
interface TaskProps {
    id: number;
}

class Task extends React.Component<TaskProps, any> {
    constructor(props: TaskProps) {
        super(props);

        this.state = {
            tasks: [],
            isLoading: false
        };
    }

    componentDidMount() {

        this.setState({isLoading: true});

        fetch('http://localhost:8080/tasks/' + this.props.id)
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
                {tasks.map((task: TaskDto) =>
                    <div key={task.id}>
                        {task.name}:
                        {task.path}:
                    </div>
                )}
            </div>
        );
    }
}

export default Task;