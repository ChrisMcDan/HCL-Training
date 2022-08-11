/*August 10, 2022*/

package com.daily.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daily.Entity.Post;

public interface PostRepo extends JpaRepository<Post, Integer>
{

}