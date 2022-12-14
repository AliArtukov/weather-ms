package uz.atoy.weatherms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.atoy.weatherms.entity.CityInfo;

@Repository
public interface CityInfoRepository extends JpaRepository<CityInfo, Integer> {
}