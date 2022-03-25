import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import java.util.Optional;

public class Main{
  public static void main(String args[]){

    CompilationUnit cu = JavaParser.parse("class A { " +
            " public static int myConstant = 43; " +
            "}");

    Optional<ClassOrInterfaceDeclaration>
            classa = cu.getClassByName("A");

    cu.findAll(FieldDeclaration.class).stream()
            .filter( f -> f.isPublic() && f.isStatic())
            .forEach( f -> {
                System.out.println("Check static field:[" +
                        f +
                        "] at line: " +
                        f.getRange().
                        map( r -> r.begin.line).orElse(-1));
            });

    System.out.println("DONE.");
  }
}
