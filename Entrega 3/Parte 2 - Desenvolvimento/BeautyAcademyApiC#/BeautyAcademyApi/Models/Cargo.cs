using System.Collections.ObjectModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace BeautyAcademyApi.Models
{
    [Table("Cargos")]
    public class Cargo
    {
        public Cargo()
        {
            Alunos = new Collection<Aluno>();
        }

        [Key]
        public int Id { get; set; }

        [Required]
        [StringLength(50)]
        public string Nome { get; set; }

        public ICollection<Aluno> Alunos { get; set; }
    }
}
