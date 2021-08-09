package shop.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import shop.domain.Member;
import shop.domain.Order;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        try {
            Order order = entityManager.find(Order.class, 1L);
            Long memberId = order.getMemberId();

            // member를 entity에서 바로 꺼내오지 않기 때문에 객체지향적이지 않다 -> table 중심의 entity 매핑 문제점
            Member member = entityManager.find(Member.class, memberId);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }
}
