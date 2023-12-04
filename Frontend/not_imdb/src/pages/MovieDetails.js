import { useState, useEffect } from "react";
import { useParams, Link  } from "react-router-dom";
import { getMovieById } from "../services/movie_service";
import '../styles/MovieDetails.css';
import Modal from 'react-modal';
import ReviewForm from "../components/review_components/ReviewForm";

function MovieDetails(props){
    const { id } = useParams();
    const [movie, setMovie] = useState({});
    const [isModalOpen, setIsModalOpen] = useState(false);

    useEffect(() => {
        getMovie();
      }, []);
    
    const getMovie = () => {
        getMovieById(id)
          .then((response) => {
            console.log(response);
            setMovie(response.data);
          })
          .catch((error) => {
            console.error("Error fetching single movie:", error);
          });
      };

      const handleOpenModal = (e) => {
        e.preventDefault();
        setIsModalOpen(true);
      };
    
      const handleCloseModal = () => {
        setIsModalOpen(false);
      };

      return (
        <div id="movieDetails">
          <h1 className="movie-details-title">{movie.Title}</h1>
          <div className="movie-details-container">
            <div className="movie-details-info">
              <h3 className="movie-details-runtime">Runtime: {movie.Runtime}</h3>
              <h3 className="movie-details-year">Year of Release: {movie.YearOfRelease}</h3>
            </div>
            <div className="movie-details-image-wrapper">
          <img src={movie.Image} alt={movie.Title} className="movie-details-image" />
        </div>
        </div>
          <div className="movie-details-reviews">
            <Link to={`/${movie.Id}/reviews`} className="movie-details-button">
              Reviews
            </Link>
            {props.user && props.user.isLoggedIn && 
              <div>
                <button className="movie-details-button" onClick={(e) => handleOpenModal(e)}>Add New Review</button>
                <Modal isOpen={isModalOpen} onRequestClose={handleCloseModal} className="modal-card">
                  <ReviewForm user={props.user} movieId={id}/>
                </Modal> 
              </div>
            }
          </div>
        </div>
      );
}

export default MovieDetails;