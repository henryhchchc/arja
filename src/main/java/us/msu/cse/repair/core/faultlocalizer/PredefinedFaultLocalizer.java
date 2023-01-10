
package us.msu.cse.repair.core.faultlocalizer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import us.msu.cse.repair.core.parser.LCNode;

/**
 * PredefinedFaultLocalizer
 */
public class PredefinedFaultLocalizer implements IFaultLocalizer {

    private final String testName;
    private final String targetClassName;
    private final int startingLineNum;
    private final int endLineNum;

    private PredefinedFaultLocalizer(
            String testName,
            String targetClassName,
            int startingLineNum,
            int endLineNum) {
        this.testName = testName;
        this.targetClassName = targetClassName;
        this.startingLineNum = startingLineNum;
        this.endLineNum = endLineNum;
    }

    @Override
    public Map<LCNode, Double> searchSuspicious(double thr) {
        Map<LCNode, Double> result = new HashMap<>();
        for (int i = startingLineNum; i <= endLineNum; i++) {
            result.put(new LCNode(targetClassName, i), 1.0);
        }
        return result;
    }

    @Override
    public Set<String> getPositiveTests() {
        return Collections.emptySet();
    }

    @Override
    public Set<String> getNegativeTests() {
        return Collections.singleton(testName);
    }

    public static PredefinedFaultLocalizer parse(String infoTxt) {
        List<String> lines = infoTxt.lines().map(it -> it.trim()).collect(Collectors.toList());
        return new PredefinedFaultLocalizer(
                lines.get(3),
                lines.get(0),
                Integer.parseInt(lines.get(1)),
                Integer.parseInt(lines.get(2)));
    }

    public static PredefinedFaultLocalizer load(String path) throws IOException {
        String content = Files.readString(new File(path).toPath());
        return parse(content);
    }

}
