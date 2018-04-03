import * as React from 'react';

interface TaskDto {
    id: number;
    projectId: number;
    name: string;
    path: string;
}
interface TaskProps {
    projectId: number;
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

        fetch('http://localhost:8080/tasks/' + this.props.projectId)
            .then(response => response.json())
            .then(data => this.setState({tasks: data, isLoading: false}));
    }
    newTask(text: number) {
        alert(text);
        let arr = this.state.tasks;
        // arr.push(task);
        this.setState({tasks: arr});
    }
    removeTask(id: number) {
        let arr = this.state.tasks;
        arr.splice(id - 1, 1);
        this.setState({tasks: arr});
    }
    render() {

        const {tasks, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div>
                <h2>Tasks</h2>

                <button onClick={this.newTask.bind(null, 'asdads')}>add</button>

                {tasks.map((task: TaskDto) =>
                    <div key={task.id}>
                        {task.id}:
                        {task.name}:
                        {task.path}
                        <button onClick={this.removeTask.bind(this, task.id)}>remove</button>
                    </div>
                )}
            </div>
        );
    }
}

export default Task;