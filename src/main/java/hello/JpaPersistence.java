package hello;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaPersistence {

    /**
     * ================
     * 영속성 컨텍스트의 이점
     * ================
     * 1차 캐시
     * 동일성 보장
     * 트랜잭션을 지원하는 쓰기 지연
     * 변경 감지
     * 지연 로딩
     */
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        try {
            // 비영속 상태 => JPA와 관련이 없는 상태
            MemberTest member = new MemberTest();
            member.setId(1L);
            member.setName("yunho");

            // 영속 => 영속성 컨텍스트에 관리를 받는 상태
            entityManager.persist(member);

            // 준영속 => 영속성 컨텍스트에 저장되었다가 분리된 상태 detach/clear/close
            // 트랜잭션 커밋이 되어도 쿼리를 질의하지 않음
            // entityManager.detach(member);

            // 삭제 => 객체를 상태한 삭제
            // entityManager.remove(member);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
