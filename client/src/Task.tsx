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

const editDivStyle = {
    zIndex: 1,
};

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

    downloadCsv() {
        setTimeout(() => {
            const response = {file: 'http://localhost:8080/downloadCSV'}; window.open(response.file); }, 100);
    }

    downloadXls() {
        setTimeout(() => {
            const response = {file: 'http://localhost:8080/download.xls'}; window.open(response.file); }, 100);
    }

    downloadPdf() {
        setTimeout(() => {
            const response = {file: 'http://localhost:8080/download.pdf'}; window.open(response.file); }, 100);
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
                <input style={editDivStyle} type="text" onChange={this.changeEditedText.bind(this, event)} defaultValue={this.state.txtForEdit}/>
                <br/>
                <input type="text" onChange={this.changePath.bind(this, event)} value={this.state.editPath}/>
                <button onClick={this.editTask.bind(this, id)}>edit</button>
            </div>
        );
    }

    changeEditedText(event: Event) {
        if (event.target != null) {
            this.setState({value: event.target.valueOf()});
        }
    }

    changePath(event: Event) {
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
                <br/>
                <button onClick={this.downloadCsv}>users csv</button>
                <button onClick={this.downloadXls}>users xls</button>
                <button onClick={this.downloadPdf}>users pdf</button>

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