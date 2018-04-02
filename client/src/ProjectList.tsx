import * as React from 'react';

interface Project {
    id: number;
    name: string;
    description: string;
}

interface ProjectListProps {

}

class ProjectList extends React.Component<{}, any> {
    constructor(props: ProjectListProps) {
        super(props);

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
    downloadXLS() {
        fetch('http://localhost:8080/download.xls').then();
    }
    render() {
        const {projects, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div>
                <h2>Project List</h2>
                {projects.map((project: Project) =>
                    <div key={project.id}>
                        {project.name}:
                        {project.description}
                        <button onClick={this.downloadXLS}>Info</button>
                    </div>
                )}
            </div>
        );
    }
}

export default ProjectList;