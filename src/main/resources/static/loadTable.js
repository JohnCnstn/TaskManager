// var App = React.createClass({
//
//     loadEmployeesFromServer: function () {
//         var self = this;
//         $.ajax({
//             url: "http://localhost:8080/employees"
//         }).then(function (data) {
//             self.setState({employees: data._embedded.employees});
//         });
//     },
//
//     getInitialState: function () {
//         return {employees: []};
//     },
//
//     componentDidMount: function () {
//         this.loadEmployeesFromServer();
//     },
//
//     render() {
//         return (<EmployeeTable employees={this.state.employees}/>);
//     }
// });
