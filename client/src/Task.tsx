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
            txtForEdit: 'name',
            editPath: 'path',
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

        let newName = this.state.txtForEdit;
        let newPath = this.state.editPath;

        let arr = this.state.tasks;

        for (let i = 0; i < arr.length; i++) {
            if (arr[i].id === id) {
                let editedTask = arr[i];
                editedTask.name = newName;
                editedTask.path = newPath;

                fetch('http://localhost:8080/tasks', {
                    method: 'put',
                    headers: {
                        'Accept': 'application/json, text/plain, */*',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({name: editedTask.name, path: editedTask.path, taskId: id})
                });

            }
        }

        this.setState({tasks: arr, edit: false});

    }

    newTask(text: string, projectId: number) {
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

        fetch('http://localhost:8080/tasks', {
            method: 'post',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({name: newTask.name, path: newTask.path, projectId: projectId})
        });
    }

    removeTask(id: number) {

        fetch('http://localhost:8080/tasks/' + id, { method: 'DELETE'})
            .then(
                data => {
                    let arr = this.state.tasks;

                    for (let i = 0; i < arr.length; i++) {
                        if (arr[i].id === id) {
                            arr.splice(i, 1);
                        }
                    }
                    this.setState({tasks: arr});
                }
            );
    }

    rendEdit(id: number) {
        return (
            <div className="box">

                <input onChange={(event) =>  this.setState({ txtForEdit: event.target.value })}/>

                <br/>

                <input onChange={(event) =>  this.setState({ editPath: event.target.value })}/>

                <button onClick={this.editTask.bind(this, id)}>edit</button>
            </div>
        );
    }

    setEdit(id: number) {
        this.setState({edit: true, idForEdit: id});
    }

    rendNorm() {
        return (
            <div>
                <h2>Tasks</h2>

                <button onClick={this.newTask.bind(this, 'custom data', this.props.projectId)}>add</button>
                <br/>

                {this.state.tasks.map((task: TaskDto) =>
                    <div key={task.id}>
                        {task.id}:
                        {task.name}:
                        {task.path}
                        <button onClick={this.setEdit.bind(this, task.id, this.props.projectId)}>edit</button>
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