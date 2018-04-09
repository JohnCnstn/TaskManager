import * as React from 'react';

class Login extends React.Component<any, any> {
    constructor(props: any) {
        super(props);

        this.state = {
            login: false,
            userName: '',
            password: ''
        };
    }

    login() {
        fetch('http://localhost:8080/myLogin', {
            method: 'post',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({userName: this.state.userName, password: this.state.password})

        });

        this.props.callbackFromParent(this.state.login);
    }

    render() {
        return (
            <div className="box">

                <input onChange={(event) => this.setState({userName: event.target.value})}/>

                <br/>

                <input onChange={(event) => this.setState({password: event.target.value})}/>

                <button onClick={this.login.bind(this, '')}>login</button>

            </div>
        );
    }
}

export default Login;