package uz.atoy.weatherms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.atoy.weatherms.entity.CityInfo;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Repository
public interface CityInfoRepository extends JpaRepository<CityInfo, Integer> {

    List<CityInfo> findAllByEnabled(@NotNull Boolean enabled);

    Optional<CityInfo> findByIdAndEnabled(Integer id, @NotNull Boolean enabled);

}