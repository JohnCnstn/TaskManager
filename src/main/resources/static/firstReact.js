var Project = React.createClass({
    render: function() {
        return (
            <tr>
                <td>{this.props.project.name}</td>
                <td>{this.props.project.quantity}</td>
                <td>{this.props.project.description}</td>
            </tr>);
    }
});

var ProjectTable = React.createClass({
    render: function() {
        var rows = [];
        this.props.projects.forEach(function(project) {
            rows.push(<Project project={project} />);
        });
        return (
            <table>
                <thead>
                <tr>
                    <th>Name</th><th>Quantity</th><th>Description</th>
                </tr>
                </thead>
                <tbody>{rows}</tbody>
            </table>);
    }
});

var App = React.createClass({

    loadProjectsFromServer: function () {
        var self = this;
        $.ajax({
            url: "http://localhost:8080/api/projects"
        }).then(function (data) {
            self.setState({projects: data._embedded.projects});
        });
    },

    getInitialState: function () {
        return {projects: []};
    },

    componentDidMount: function () {
        this.loadProjectsFromServer();
    },

    render() {
        return ( <ProjectTable projects={this.state.projects}/> );
    }
});



ReactDOM.render(<App />, document.getElementById('root') );

