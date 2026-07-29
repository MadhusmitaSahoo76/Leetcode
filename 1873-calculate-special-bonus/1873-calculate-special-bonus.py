import pandas as pd

def calculate_special_bonus(employees: pd.DataFrame) -> pd.DataFrame:

    employees['ch_bonus'] = ~employees.name.str.startswith('M')
    employees['id_bonus'] = employees.employee_id%2
    employees.salary*= employees.ch_bonus * employees.employee_id%2

    return (employees.rename(columns = {'salary':'bonus'})
                    .sort_values('employee_id').iloc[:,[0,2]])
    