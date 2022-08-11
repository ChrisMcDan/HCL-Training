/*August 10, 2022*/

package com.daily.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daily.Entity.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer>
{
	Optional<User> findByUserName(String username);// custom methods
}