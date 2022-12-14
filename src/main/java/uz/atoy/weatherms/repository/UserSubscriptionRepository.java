package uz.atoy.weatherms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.atoy.weatherms.entity.UserSubscription;

import java.util.List;

@Repository
public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Integer> {

    List<UserSubscription> findAllByUser_Id(Integer id);

}