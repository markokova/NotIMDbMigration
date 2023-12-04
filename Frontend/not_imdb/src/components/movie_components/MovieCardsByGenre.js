import { getGenres } from "../../services/genre_service";
import { useState, useEffect } from "react";

function MovieCardsByGenre(){
    
    const[genres, setGenres] = useState([]);

    useEffect(() => {
        getGenres().then((response) => {
            setGenres(response.data.genreRests);
        }).catch((error) => {
            console.error("Error fetching genres.", error);
        });
    }, []);
    
    return(
        <div>
            {genres.map((genre) => (
                <p>Id: {genre.Id}, Title: {genre.Title}</p>
            ))}
        </div>
    );
}


export default MovieCardsByGenre;