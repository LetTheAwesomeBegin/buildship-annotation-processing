package com.pattycake.example;

import static org.assertj.core.api.Assertions.*;

import com.pattycake.example.api.NewBuilding;
import com.pattycake.example.api.OldBuilding;
import com.pattycake.example.core.BuildingMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BuildingMapperTest {

  @Autowired private BuildingMapper sut;

  @Test
  void map_givenOldBuilding_expectNewBuilding() throws Exception {
    // Given
    String buildingName = "Shawkn Spire";
    OldBuilding given = OldBuilding.builder().name(buildingName).build();

    // When
    NewBuilding actual = sut.map(given);

    // Expect
    assertThat(actual.getName()).isEqualTo(buildingName);
  }
}
