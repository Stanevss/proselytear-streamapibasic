package main.java.net.proselyte.steamapi;

import main.java.net.proselyte.steamapi.model.Specialist;
import main.java.net.proselyte.steamapi.model.Specialty;
import main.java.net.proselyte.steamapi.util.OldApproachUtil;
import main.java.net.proselyte.steamapi.util.StreamAPIUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class StreamAPIDemo {
    public static void main(String[] args) {
        List<Specialist> specialists = StreamAPIUtil.getSpecialists();


        // Filter
        List<Specialist> engineers = OldApproachUtil.filterBySpecialty(specialists, Specialty.ENGINEER);

        StreamAPIUtil.filterBySpecialty(specialists, Specialty.ENGINEER);

        // Sorting
        List<Specialist> sortedSpecialistsAsc = StreamAPIUtil.sortSpecialistsByNameAsc(specialists);
        List<Specialist> sortedSpecialistsDesc = StreamAPIUtil.sortSpecialistsByNameDesc(specialists);

        // Max salary
        Specialist withMaxSalary = StreamAPIUtil.findWithMaxSalary(specialists);

        // Min salary
        Specialist withMinSalary = StreamAPIUtil.findWithMinSalary(specialists);

        // Grouping
        Map<Specialty, List<Specialist>> groupedBySpeciality = StreamAPIUtil.groupBySpecialty(specialists);


        // All engineers
        boolean allEngineers = StreamAPIUtil.matchAllEngineers(specialists);

        // Any Engineer
        boolean anyEngineer = StreamAPIUtil.matchAnyEngineer(specialists);

        // No one with salary more then
        boolean noOneWithSalaryMoreThen10000 = StreamAPIUtil.matchNoneSalaryMoreThen(specialists, new BigDecimal(10000));
        System.out.println(noOneWithSalaryMoreThen10000);
    }
}
