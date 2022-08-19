package com.tcv.hwelectrocasnice;

import com.tcv.hwelectrocasnice.model.Appliance;
import com.tcv.hwelectrocasnice.model.ApplianceType;
import com.tcv.hwelectrocasnice.repository.ApplianceRepository;
import com.tcv.hwelectrocasnice.service.ApplianceService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplianceServiceTest {

    @Mock
    ApplianceRepository applianceRepository;
    @InjectMocks
    ApplianceService applianceService;

    @Test
    public void it_should_save_appliance() throws Exception{
        Appliance testAppliance = new Appliance(null,"Aragaz", ApplianceType.ELB, 10, false);
        when(applianceRepository.save(any(Appliance.class))).thenReturn(new Appliance());
        Appliance created = applianceService.saveAppliance(testAppliance);
        assertThat(created.getName()).isSameAs(testAppliance.getName());
    }

    @Test
    public void it_should_find_user_byEmail() {
        Appliance testAppliance = new Appliance(null,"Aragaz", ApplianceType.ELB, 11, false);
        assertThat(applianceService.addStock(1)).isEqualTo(testAppliance);
    }
}
