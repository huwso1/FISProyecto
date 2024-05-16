import React, { useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

const SearchBar = ({ onSearch }) => {
    const [searchTerm, setSearchTerm] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        onSearch(searchTerm);
    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                placeholder="Buscar..."
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
            />
            <button type="submit"><img src={require("./Imagenes/iconolupa.png")} alt="icon"/></button>
        </form>
    );
};

const BarraDeBusqueda = () => {
    const [searchResults, setSearchResults] = useState([]);

    const handleSearch = (searchTerm) => {
        // Perform a search with the given search term
        // and update the `searchResults` state with the results
    };

    return (
        <div className="d-flex flex-column align-items-center">
            <h1 className="w-100 text-center">Inserte la identificacion del usuario</h1>
            <SearchBar onSearch={handleSearch}/>
            {/* Render the search results */}
        </div>
    );
};

const Tabla = () => {
    const data = [
        { id: 1, name: 'John Doe', age: 30, city: 'New York' },
        { id: 2, name: 'Jane Doe', age: 25, city: 'Los Angeles' },
        { id: 3, name: 'Mike Johnson', age: 40, city: 'Chicago' },
    ];

    return (
        <div>
            <table className="table table-striped">
                <thead>
                <tr>
                    <th>Recurso</th>
                    <th>Hora Inicio</th>
                    <th>Hora fin</th>
                </tr>
                </thead>
                <tbody>
                {data.map((item) => (
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.name}</td>
                        <td>{item.city}</td>
                    </tr>
                ))}
                </tbody>
            </table>
            <div className="d-flex justify-content-center">
                <button className="btn btn-primary mr-2">Prestar</button>
                <button className="btn btn-primary">Devolver</button>
            </div>
        </div>
    );
};

function VistaEmpleado() {
    return (
        <div className="container">
            <BarraDeBusqueda/>
            <Tabla/>
        </div>
    )
}

export default VistaEmpleado;