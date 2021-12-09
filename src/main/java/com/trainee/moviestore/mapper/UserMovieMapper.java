package com.trainee.moviestore.mapper;

import com.trainee.moviestore.dto.UserMovieDto;
import com.trainee.moviestore.model.UserMovie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMovieMapper {

    UserMovieMapper INSTANCE = Mappers.getMapper(UserMovieMapper.class);

    UserMovieDto toDto(List<UserMovie> userMovie);
}
