import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import junit.framework.TestCase;
import jdepend.framework.JavaPackage;
import jdepend.framework.JDepend;
import com.beer.common.PropertyReader;

public class ArchitecturalRulesTest extends TestCase {

    PropertyReader propReader = new PropertyReader("default");

	private final String DIRECTORY_TO_ANALYZE = propReader.getProperty("classes.directory.jdepend");
	private JDepend jdepend;
	private String dataLayer = "com.beer.business.data";
	private String presentationLayer = "com.beer.web";
	private String businessLayer = "com.beer.business.service";
	private String domainLayer = "com.beer.business.domain";
	private Collection dataLayerViolations = new ArrayList<String>();
	private Collection businessLayerViolations = new ArrayList<String>();
	private Collection presoLayerViolations = new ArrayList<String>();
	private Collection domainLayerViolations = new ArrayList<String>();

	public ArchitecturalRulesTest(String name) {
		super(name);
	}

	protected void setUp() throws IOException {
		jdepend = new JDepend();
		jdepend.addDirectory(DIRECTORY_TO_ANALYZE);
		dataLayerViolations.add(businessLayer);
		dataLayerViolations.add(presentationLayer);
		businessLayerViolations.add(presentationLayer);
		presoLayerViolations.add(dataLayer);
		domainLayerViolations.add(businessLayer);
		domainLayerViolations.add(dataLayer);
		domainLayerViolations.add(presentationLayer);
	}

	public void testDomainLayer() {
		System.out.println("Testing Domain Layer...");
		if (!isLayeringValid(domainLayer, domainLayerViolations)) {
			fail("Dependency Constraint failed in Domain Layer");
		}
	}

	private boolean isLayeringValid(String layer, Collection rules) {
		boolean rulesCorrect = true;
		System.out.println("Testing Generic Layer...");
		Collection packages = jdepend.analyze();
		Iterator itor = packages.iterator();
		JavaPackage jPackage = null;
		String analyzedPackageName = null;
		while (itor.hasNext()) {
			jPackage = (JavaPackage) itor.next();
			analyzedPackageName = jPackage.getName();
			Collection afferents = jPackage.getAfferents();
			Iterator afferentItor = afferents.iterator();
			String afferentPackageName = null;
			System.out.println("analyzedPackageName=" + analyzedPackageName);
			while (afferentItor.hasNext()) {
				JavaPackage afferentPackage = (JavaPackage) afferentItor.next();
				afferentPackageName = afferentPackage.getName();
				System.out
						.println("afferentPackageName=" + afferentPackageName);
			}
			rulesCorrect = checkEfferents(layer, rules, rulesCorrect, jPackage,
					analyzedPackageName);
		}
		return rulesCorrect;
	}

	private boolean checkEfferents(String layer, Collection rules,
			boolean rulesCorrect, JavaPackage jPackage,
			String analyzedPackageName) {
		Collection efferents = jPackage.getEfferents();
		Iterator efferentItor = efferents.iterator();
		while (efferentItor.hasNext()) {
			JavaPackage efferentPackage = (JavaPackage) efferentItor.next();
			String efferentPackageName = efferentPackage.getName();
			System.out.println("efferentPackageName=" + efferentPackageName);

			for (Iterator it = rules.iterator(); it.hasNext();) {
				String value = (String) it.next();
				System.out.println("layer=" + layer);
				System.out.println("value=" + value);
				if (analyzedPackageName.equals(layer)
						&& efferentPackageName.equals(value)) {
					rulesCorrect = false;

					System.out
							.println("TEST FAILURE: "
									+ analyzedPackageName
									+ " should not depend upon (have an efferent coupling to) "
									+ efferentPackageName);
					break;
				}
			}

		}
		return rulesCorrect;
	}

	public void testDataLayer() {
		System.out.println("Testing Data Layer...");
		if (!isLayeringValid(dataLayer, dataLayerViolations)) {
			fail("Dependency Constraint failed in data Layer");
		}
	}

	public void testBusinessLayer() {
		System.out.println("Testing Business Layer...");
		if (!isLayeringValid(businessLayer, businessLayerViolations)) {
			fail("Dependency Constraint failed in business Layer");
		}
	}

	public void testPresentationLayer() {
		System.out.println("Testing Presentation Layer...");
		if (!isLayeringValid(presentationLayer, presoLayerViolations)) {
			fail("Dependency Constraint failed in Presentation Layer");
		}
	}

}