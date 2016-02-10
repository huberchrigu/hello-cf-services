package ch.huber.cloud.demo.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * @author christoph.huber
 */
public interface TaskRepository extends CrudRepository<Task, Long> {
}
