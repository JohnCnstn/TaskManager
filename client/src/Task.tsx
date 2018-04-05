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
            idForEdit: -1,
            txtForEdit: 'edited txt',
            edit: false,
            isLoading: false
        };
    }

    componentDidMount() {

        this.setState({isLoading: true});

        fetch('http://localhost:8080/tasks/' + this.props.projectId)
            .then(response => response.json())
            .then(data => this.setState({tasks: data, isLoading: false}));
    }

    editTask(id: number) {

        var text = this.state.txtForEdit;

        let arr = this.state.tasks;

        for (let i = 0; i < arr.length; i++) {
            if (arr[i].id === id) {
                let editedTask  = arr[i];
                editedTask.name  = text;
                editedTask.path  = text;
            }
        }

        this.setState({tasks: arr, edit: false});
    }

    newTask(text: string) {
        let arr = this.state.tasks;
        let newTask = new NewTask();
        if (arr.length === 0) {
            newTask.id = 0;
        } else {
            let lastTask = arr[arr.length - 1];
            newTask.id = lastTask.id + 1;
        }
        newTask.name = text;
        newTask.path = text;
        arr.push(newTask);
        this.setState({tasks: arr});
    }

    removeTask(id: number) {
        let arr = this.state.tasks;

        for (let i = 0; i < arr.length; i++) {
            if (arr[i].id === id) {
                arr.splice(i, 1);
            }
        }
        this.setState({tasks: arr});
    }

    rendEdit(id: number) {
        return (
            <div className="box">
                <input type="text" onChange={this.changeEditedText.bind(this, event)} value={this.state.txtForEdit}/>
                <button onClick={this.editTask.bind(this, id)}>edit</button>
            </div>
        );
    }

    changeEditedText(event: Event) {
        if (event.target != null) {
            this.setState({value: event.target.valueOf()});
        }
    }

    setEdit(id: number) {
        this.setState({edit: true, idForEdit: id});
    }

    rendNorm() {
        return (
            <div>
                <h2>Tasks</h2>

                <button onClick={this.newTask.bind(this, 'custom data')}>add</button>

                {this.state.tasks.map((task: TaskDto) =>
                    <div key={task.id}>
                        {task.id}:
                        {task.name}:
                        {task.path}
                        <button onClick={this.setEdit.bind(this, task.id)}>edit</button>
                        <button onClick={this.removeTask.bind(this, task.id)}>remove</button>
                    </div>
                )}
            </div>
        );
    }

    render() {
        if (this.state.edit) {
            return this.rendEdit(this.state.idForEdit);
        } else {
            return this.rendNorm();
        }
    }
}

export default Task;