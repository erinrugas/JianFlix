package com.jianastrero.movie_data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jianastrero.movie_data.local.model.Movie

/**
 * Local Database Transactions for Movies
 *
 * @author Jian James P. Astrero
 */
@Dao
interface MovieDao {

    /**
     * Get All Movies
     *
     * @author Jian James P. Astrero
     */
    @Query("SELECT * FROM movies")
    suspend fun getAll(): List<Movie>

    /**
     * Get a Movie using its id
     *
     * @param id The id of the movie
     *
     * @author Jian James P. Astrero
     */
    @Query("SELECT * FROM movies WHERE id = :id LIMIT 1")
    suspend fun getById(id: Int): Movie

    /**
     * Insert List of Movies
     *
     * @param movies List of Movies to insert to local database
     *
     * @author Jian James P. Astrero
     */
    @Insert
    suspend fun insertAll(movies: List<Movie>)

    /**
     * Delete all Movies
     *
     * @author Jian James P. Astrero
     */
    @Query("DELETE FROM movies")
    suspend fun clear()

}