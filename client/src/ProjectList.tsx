import * as React from 'react';
import Task from './Task';
import './list.css';

interface Project {
    id: number;
    name: string;
    description: string;
}

class ProjectList extends React.Component<any, any> {
    constructor() {
        super({});

        this.state = {
            projects: [],
            isLoading: false
        };
    }

    componentDidMount() {
        this.setState({isLoading: true});

        if ((this.props.role === 'MANAGER') || (this.props.role === 'ADMIN')) {

            fetch('http://localhost:8080/projects')
                .then(response => response.json())
                .then(data => this.setState({projects: data, isLoading: false}));

        }

        if ((this.props.role === 'WORKER')) {

            fetch('http://localhost:8080/project/' + this.props.userName)
                .then(response => response.json())
                .then(data => this.setState({projects: data, isLoading: false}));

        }
    }

    render() {
        const {projects, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
                <div>
                    <h2>Projects</h2>
                    <table>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Tasks</th>
                        </tr>
                        {projects.map((project: Project) =>
                            <tr key={project.id}>
                                <td>{project.name}</td>
                                <td>{project.description}</td>
                                <td><Task projectId={project.id}/></td>
                            </tr>
                        )}
                    </table>
                </div>
        );
    }
}

export default ProjectList;