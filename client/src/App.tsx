import * as React from 'react';

import './App.css';

import CountryList from './CountryList';
import {BrowserRouter as Router, Link, Route, Switch } from 'react-router-dom';
import TourList from './TourList';
import ManagerList from './ManagerList';
import ClientList from './ClientList';

class App extends React.Component<any, any> {

    constructor(props: any) {
        super(props);

        this.state = {
            role: 'none',
            userName: '',
            password: '',
            classname: 'login-box'
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
        this.setState( {classname: 'hide'});
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
        this.setState({role: 'none', classname: 'login-box', userName: '', password: ''});
    }

    render() {
        return (
            <Router>
                <div>
                    <div className="App">
                        <div className="App-header">
                            <h2>Welcome to Tour Manager App</h2>
                            <div className={this.state.classname}>
                                <label>Login</label>
                                <input value={this.state.userName} onChange={(event) => this.setState({userName: event.target.value})}/>
                                <label>Password</label>
                                <input type="password" value={this.state.password} onChange={(event) => this.setState({password: event.target.value})}/>
                                <button onClick={this.login.bind(this, '')}>Login</button>
                            </div>
                        </div>
                    </div>
                    <ul className="top-menu">
                        <li>
                            <Link to={'/managers'}>ManagerList</Link>
                        </li>
                        <li>
                            <Link to={'/clients'}>ClientList</Link>
                        </li>
                        <li>
                            <Link to={'/countries'}>CountriesList</Link>
                        </li>
                        <li>
                            <Link to={'/tours'}>TourList</Link>
                        </li>
                        <li>
                            <button onClick={this.downloadCsv.bind(this, '')}>Users CSV</button>
                        </li>
                        <li>
                            <button onClick={this.downloadXls.bind(this, '')}>Users XLS</button>
                        </li>
                        <li>
                            <button onClick={this.downloadPdf.bind(this, '')}>Users PDF</button>
                        </li>
                        <li>
                            <button onClick={this.logout.bind(this, '')}>Logout</button>
                        </li>
                    </ul>

                    <Switch>
                        <Route path="/managers" render={routeProps => <ManagerList role={this.state.role}/>}/>
                        <Route path="/clients" component={ClientList}/>
                        <Route path="/countries" render={routeProps => <CountryList userName={this.state.userName} role={this.state.role}/>}/>
                        <Route path="/tours" component={TourList}/>
                    </Switch>
                </div>
            </Router>
        );
    }
}

export default App;