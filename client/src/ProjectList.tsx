import * as React from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import Task from './Task';

interface Project {
    id: number;
    name: string;
    description: string;
}

class ProjectList extends React.Component<{}, any> {
    constructor() {
        super({});

        this.state = {
            projects: [],
            isLoading: false
        };
    }

    componentDidMount() {
        this.setState({isLoading: true});

        fetch('http://localhost:8080/projects')

            .then(response => response.json())
            .then(data => this.setState({projects: data, isLoading: false}));
    }

    render() {
        const {projects, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <Router>
                <div>
                    <h2>Project List</h2>
                    {projects.map((project: Project) =>
                        <div key={project.id}>
                            {project.name}:
                            {project.description}

                            <Link to={'/tasks/' + project.id}>Task</Link>

                            <Switch>
                                <Route path={'/tasks/' + project.id} render={() => <Task projectId={project.id}/>}/>
                            </Switch>

                        </div>
                    )}
                </div>
            </Router>
        );
    }
}

export default ProjectList;