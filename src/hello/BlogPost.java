/**
 * 
 */
package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author kxhb130
 *
 */
public class BlogPost implements Comparable<BlogPost> {
	String title;
	String author;
	BlogPostType type;
	int likes;

	/**
	 * @param title
	 * @param author
	 * @param type
	 * @param likes
	 */
	public BlogPost(String title, String author, BlogPostType type, int likes) {
		this.title = title;
		this.author = author;
		this.type = type;
		this.likes = likes;
	}

	public static void main(String[] s) {
		List<BlogPost> list = new ArrayList<>();
		IntStream.range(0, 5).forEach(action -> list
				.add(new BlogPost(String.valueOf(action), String.valueOf(action), BlogPostType.NEWS, action)));
		IntStream.range(0, 15).forEach(action -> list
				.add(new BlogPost(String.valueOf(action), String.valueOf(action), BlogPostType.REVIEW, action)));
		IntStream.range(0, 20).forEach(action -> list
				.add(new BlogPost(String.valueOf(action), String.valueOf(action), BlogPostType.GUIDE, action)));

		Map<BlogPostType, Set<BlogPost>> mapp = list.stream().collect(Collectors.groupingBy(BlogPost::getType, Collectors.toSet()));

		mapp.keySet().forEach(action -> {
			System.out.println(action + " -> " + mapp.get(action).size());
		});
		
		Map<BlogPostType, Integer> summ = list.stream()
					.collect(Collectors.groupingBy(BlogPost::getType, Collectors.summingInt(BlogPost::getLikes)));
		summ.forEach((i, v) -> System.out.println(i +" -> "+ v));
	}

	/**
	 * @return the type
	 */
	public BlogPostType getType() {
		return type;
	}

	@Override
	public int compareTo(BlogPost o) {
		if (likes > o.likes)
			return 1;
		else if (likes < o.likes)
			return -1;
		else
			return 0;
	}

	/**
	 * @return the likes
	 */
	public int getLikes() {
		return likes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + likes;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof BlogPost)) {
			return false;
		}
		BlogPost other = (BlogPost) obj;
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		if (likes != other.likes) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (type != other.type) {
			return false;
		}
		return true;
	}
}
