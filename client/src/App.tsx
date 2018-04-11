import * as React from 'react';

import './App.css';

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
        if (this.state.role === 'ADMIN') {
            setTimeout(() => {
                const response = {file: 'http://localhost:8080/downloadCSV'};
                window.open(response.file);
            }, 100);
        } else {
            alert('Access denied!');
        }
    }

    downloadXls() {
        if (this.state.role === 'ADMIN') {
            setTimeout(() => {
                const response = {file: 'http://localhost:8080/download.xls'};
                window.open(response.file);
            }, 100);
        } else {
            alert('Access denied!');
        }
    }

    downloadPdf() {
        if (this.state.role === 'ADMIN') {
            setTimeout(() => {
                const response = {file: 'http://localhost:8080/download.pdf'};
                window.open(response.file);
            }, 100);
        } else {
            alert('Access denied!');
        }
    }

    login() {
        fetch('http://localhost:8080/myLogin', {
            method: 'post',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({userName: this.state.userName, password: this.state.password})
        }).then(response => {

            if (response.status === 500) {
                alert('Wrong username or password!');
            }

            return response.text();
        }).then(data => this.setState({role: data}));

    }

    logout() {
        this.setState({role: 'none'});
    }

    render() {
        return (
                <Router>
                    <div>
                        <div className="App">
                            <div className="App-header">
                                <h2>Welcome to Task Manager App</h2>

                        <div className="box">

                            <input onChange={(event) => this.setState({userName: event.target.value})}/>

                            <br/>

                            <input type="password" onChange={(event) => this.setState({password: event.target.value})}/>

                            <button onClick={this.login.bind(this, '')}>login</button>

                        </div>

                            </div>
                        </div>
                                <img src={logo} className="App-logo" alt="logo"/>
                        <ul>
                            <li><Link to={'/managers'}>ManagerList</Link></li>
                            <li><Link to={'/workers'}>WorkerList</Link></li>
                            <li><Link to={'/projects'}>ProjectList</Link></li>
                            <li><Link to={'/tasks'}>TaskList</Link></li>

                            <button onClick={this.downloadCsv.bind(this, '')}>users csv</button>
                            <button onClick={this.downloadXls.bind(this, '')}>users xls</button>
                            <button onClick={this.downloadPdf.bind(this, '')}>users pdf</button>

                            <button onClick={this.logout.bind(this, '')}>Logout</button>

                        </ul>

                        <Switch>
                            <Route path="/managers" render={routeProps => <ManagerList role={this.state.role}/>}/>
                            <Route path="/workers" component={WorkerList}/>
                            <Route path="/projects" render={routeProps => <ProjectList userName={this.state.userName} role={this.state.role}/>}/>
                            <Route path="/tasks" component={TaskList}/>
                        </Switch>
                    </div>
                </Router>
        );
    }
}
export default App;