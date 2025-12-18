@Entity
public class BreachReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int daysDelayed;
    private String ruleName;
    private String summary;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    // getters & setters
}
