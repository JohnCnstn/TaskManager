import * as React from 'react';

import './App.css';
import { Form } from 'react-bootstrap';

import ProjectList from './ProjectList';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import TaskList from './TaskList';
import ManagerList from './ManagerList';
import WorkerList from './WorkerList';

const logo = require('./logo.svg');

class App extends React.Component<any, any> {

    constructor(props: any) {
        super(props);

        this.state = {
            role: 'none',
            userName: '',
            password: ''
        };
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

    login() {
        fetch('http://localhost:8080/myLogin', {
            method: 'post',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({userName: this.state.userName, password: this.state.password})

        })            .then(response => {
            if (response.status === 200) {
                this.setState({role: 'MANAGER'});
                alert('good job');
            } else {
                alert('wrong username or password');
            }
        });

    }

    logout() {
        this.setState({role: 'none'});
    }

    render() {
        return (
            <Form componentClass="fieldset">
                <Router>
                    <div>
                        <div className="App">
                            <div className="App-header">
                                <img src={logo} className="App-logo" alt="logo"/>
                                <h2>Welcome to Task Manager App</h2>
                            </div>
                        </div>
                        <h2>Welcome to React Router Tutorial</h2>

                        <div className="box">

                        <input onChange={(event) => this.setState({userName: event.target.value})}/>

                        <br/>

                        <input onChange={(event) => this.setState({password: event.target.value})}/>

                        <button onClick={this.login.bind(this, '')}>login</button>

                        </div>

                        <ul>
                            <li><Link to={'/managers'}>ManagerList</Link></li>
                            <li><Link to={'/workers'}>WorkerList</Link></li>
                            <li><Link to={'/projects'}>ProjectList</Link></li>
                            <li><Link to={'/tasks'}>TaskList</Link></li>

                            <button onClick={this.downloadCsv}>users csv</button>
                            <button onClick={this.downloadXls}>users xls</button>
                            <button onClick={this.downloadPdf}>users pdf</button>

                            <button onClick={this.logout.bind(this, '')}>Logout</button>

                        </ul>
                        <hr/>

                        <Switch>
                            <Route path="/managers" render={routeProps => <ManagerList role={this.state.role}/>}/>
                            <Route path="/workers" component={WorkerList}/>
                            <Route path="/projects" component={ProjectList}/>
                            <Route path="/tasks" component={TaskList}/>
                        </Switch>
                    </div>
                </Router>
            </Form>
        );
    }
}

export default App;