var Country = React.createClass({
    render: function() {
        return (
            <tr>
                <td>{this.props.country.name}</td>
                <td>{this.props.country.quantity}</td>
                <td>{this.props.country.description}</td>
            </tr>);
    }
});

var CountryTable = React.createClass({
    render: function() {
        var rows = [];
        this.props.countries.forEach(function(country) {
            rows.push(<Country country={country: country} />);
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

    loadCountriesFromServer: function () {
        var self = this;
        $.ajax({
            url: "http://localhost:8080/api/countries"
        }).then(function (data) {
            self.setState({countries: data._embedded.countries});
        });
    },

    getInitialState: function () {
        return {countries: []};
    },

    componentDidMount: function () {
        this.loadCountriesFromServer();
    },

    render() {
        return ( <CountryTable countries={this.state.countries}/> );
    }
});



ReactDOM.render(<App />, document.getElementById('root') );

