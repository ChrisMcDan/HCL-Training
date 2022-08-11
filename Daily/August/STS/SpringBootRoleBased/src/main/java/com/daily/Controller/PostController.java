/*August 10, 2022*/

package com.daily.Controller;

import com.daily.Entity.Post;
import com.daily.Entity.PostStatus;
import com.daily.Repository.PostRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
public class PostController
{

	@Autowired
	private PostRepo postRepo;

	@PostMapping("/create")
	public String createPost(@RequestBody Post post, Principal principal)
	{
		post.setStatus(PostStatus.PENDING);
		post.setUserName(principal.getName());
		postRepo.save(post);
		return principal.getName() + " Your post published successfully , Required ADMIN/MODERATOR Action !";
	}

	@GetMapping("/approvePost/{postId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODERATOR')")
	public String approvePost(@PathVariable int postId)
	{
		Post post = postRepo.findById(postId).get();
		post.setStatus(PostStatus.APPROVED);
		postRepo.save(post);
		return "Post Approved !!";
	}

	@GetMapping("/approveAll")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODERATOR')")
	public String approveAll()
	{
		postRepo.findAll().stream().filter(post -> post.getStatus().equals(PostStatus.PENDING)).forEach(post ->
		{
			post.setStatus(PostStatus.APPROVED);
			postRepo.save(post);
		});
		return "Approved all posts !";
	}

	@GetMapping("/removePost/{postId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODERATOR')")
	public String removePost(@PathVariable int postId)
	{
		Post post = postRepo.findById(postId).get();
		post.setStatus(PostStatus.REJECTED);
		postRepo.save(post);
		return "Post Rejected !!";
	}

	@GetMapping("/rejectAll")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODERATOR')")
	public String rejectAll()
	{
		postRepo.findAll().stream().filter(post -> post.getStatus().equals(PostStatus.PENDING)).forEach(post ->
		{
			post.setStatus(PostStatus.REJECTED);
			postRepo.save(post);
		});
		return "Rejected all posts !";
	}

	@GetMapping("/viewAll")
	public List<Post> viewAll()
	{
		return postRepo.findAll().stream().filter(post -> post.getStatus().equals(PostStatus.APPROVED))
				.collect(Collectors.toList());
	}
}