using System.Collections.ObjectModel;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace BeautyAcademyApi.Models
{
    [Table("Alunos")]
    public class Aluno
    {
        public Aluno()
        {
            MatriculaCursos = new Collection<MatriculaCurso>();
        }

        [Key]
        public int Matricula { get; set; }

        [Required]
        [StringLength(80)]
        public string? Email { get; set; }

        [Required]
        [StringLength(50)]
        public string? Senha { get; set; }

        [Required]
        [StringLength(80)]
        public string? Nome { get; set; }

        [Required]
        [StringLength(11)]
        public long Celular { get; set; }

        [JsonIgnore]
        public Cargo? Cargo { get; set; }

        public ICollection<MatriculaCurso> MatriculaCursos { get; set; }
    }
}
