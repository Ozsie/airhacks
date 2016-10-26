package com.airhacks.plants.entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class BiosphereIT {

    private EntityManager em;
    private EntityTransaction tx;

    @Before
    public void init() {
        this.em = Persistence.createEntityManagerFactory("it").
                createEntityManager();
        this.tx = this.em.getTransaction();
    }

    @Test
    public void crud() {
        this.tx.begin();
        int expected = 42;
        this.em.merge(new Biosphere(expected, "very good"));
        this.tx.commit();

        List<Biosphere> resultWith42 = this.em.createNamedQuery("findByTemp", Biosphere.class).
                setParameter("temperature", expected).getResultList();
        long biospheresNot42 = resultWith42.
                stream().
                filter(b -> (b.getTemperature() != expected)).count();
        assertThat(biospheresNot42, is(0l));

    }

}
