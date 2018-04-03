import * as React from 'react';

class NewTask {
    id: number;
    name: string;
    path: string;
}

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
    newTask(text: string) {
        let arr = this.state.tasks;
        let lastTask = arr[ arr.length - 1 ];
        let newTask = new NewTask();
        newTask.id = lastTask.id + 1;
        newTask.name = text;
        newTask.path = text;

        arr.push(newTask);
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

                <button onClick={this.newTask.bind(this, 'custom data')}>add</button>

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