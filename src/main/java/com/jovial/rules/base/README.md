Supporting classes for rule execution. `Rule` is a minimal interface used by the
sensor, `RuleRegistry` keeps track of active rules and `IssueReporter` provides
a small helper for raising issues. These implementations are intentionally light
weight to keep the proof of concept simple.
