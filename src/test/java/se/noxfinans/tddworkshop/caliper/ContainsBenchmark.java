package se.noxfinans.tddworkshop.caliper;

import com.google.caliper.BeforeExperiment;
import com.google.caliper.Benchmark;
import com.google.caliper.Param;
import com.google.caliper.api.VmOptions;
import com.google.caliper.runner.CaliperMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@VmOptions("-XX:-TieredCompilation")
public class ContainsBenchmark
{
	@Param({"0", "25", "50", "75", "100"})
	private int percentNulls;

	@Param({"100", "1000", "10000"})
	private int containsPerRep;

	/** the set under test */
	private final Set<String> set = new HashSet<String>();

	/** twenty-five percent nulls */
	private final List<Object> queries = new ArrayList<Object>();

	@BeforeExperiment
	void setUp() {
		set.addAll(Arrays.asList("str1", "str2", "str3", "str4"));
		int nullThreshold = percentNulls * containsPerRep / 100;
		for (int i = 0; i < nullThreshold; i++) {
			queries.add(null);
		}
		for (int i = nullThreshold; i < containsPerRep; i++) {
			queries.add(new Object());
		}
		Collections.shuffle(queries, new Random(0));
	}

	@Benchmark
	void contains(int reps) {
		for (int i = 0; i < reps; i++) {
			for (Object query : queries) {
				set.contains(query);
			}
		}
	}

	public static void main(String[] args)
	{
		CaliperMain.main(ContainsBenchmark.class, new String[]{});
	}
}
