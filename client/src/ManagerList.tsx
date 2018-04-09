import * as React from 'react';

interface Manager {
    id: number;
    firstName: string;
    lastName: string;
}

class ManagerList extends React.Component<any, any> {
    constructor(props: any) {
        super(props);

        this.state = {
            managers: [],
            isLoading: false
        };
    }

    componentDidMount() {
        this.setState({isLoading: true});

        if (this.props.role === 'MANAGER') {

            fetch('http://localhost:8080/managers')
                .then(response => response.json())
                .then(data => this.setState({managers: data, isLoading: false}));

        }
    }
    render() {
        const {managers, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div>
                <h2>Manager List</h2>
                {managers.map((manager: Manager) =>
                    <div key={manager.id}>
                        {manager.firstName}:
                        {manager.lastName}
                    </div>
                )}
            </div>
        );
    }
}

export default ManagerList;