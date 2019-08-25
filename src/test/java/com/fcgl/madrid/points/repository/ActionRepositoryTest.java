package com.fcgl.madrid.points.repository;
import com.fcgl.madrid.points.model.Action;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ActionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ActionRepository actionRepository;

    @Test
    public void findByIdTest() {
        Action action = new Action("Testing action");
        entityManager.persist(action);
        entityManager.flush();
        Long actionId = action.getId();
        Action found = actionRepository.findById(actionId).get();
        assertEquals(found.getDescription(), action.getDescription());
    }
}
